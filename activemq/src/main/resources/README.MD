一、spring-jms集成activeMQ的流程和思路
  1、导入activemq-all的相关jar、spring-jms的jar
  2、新建spring-jms.xml配置文件，在配置文件中配置bean
    1）、首先使用activeMQ提供的连接工厂类产生Connection的ConnectionFactory
        <bean id="targetConnectionFactory" class="org.apache.activemq.ActiveMQConnectionFactory">
            <property name="brokerURL" value="tcp://localhost:61616"/>
        </bean>
    2）、将ConnectionFactory 生产的Connection、Session和MessageProducer池化
        <bean id="poolConnectionFactory" class="org.apache.activemq.pool.PooledConnectionFactory">
            <property name="connectionFactory" ref="targetConnectionFactory"/>
            <property name="maxConnections" value="10"/>
        </bean>
    3)、让spring提供的jms来管理池
        <bean id="connectionFactory" class="org.springframework.jms.connection.SingleConnectionFactory">
             <property name="targetConnectionFactory" ref="poolConnectionFactory"/>
        </bean>
    4）、配置消息生产者（配置进行消息发送的JmsTemplate）对象就是池中的这些Connection、Session和MessageProducer
        <bean id="jmsTemplate" class="org.springframework.jms.core.JmsTemplate">
            <property name="connectionFactory" ref="connectionFactory"/>
        </bean>

        备注:模板中还可以配置消息转换器
        <!--消息转换器-->
        <bean id="executeLogConverter" class="com.rainbow.packge.jms.MyExecuteLogConverter"/>
        <bean id="jmsTemplate" class="org.springframework.jms.core.JmsTemplate">
            <property name="connectionFactory" ref="connectionFactory"/>
            <property name="messageConverter" ref="executeLogConverter" />
        </bean>
    5）、消息队列--配置消息生产者生产的消息发送到哪个目的地（有两种方式：点对点|一对多）
        1):一对一配置
        <bean id="queueDestination" class="org.apache.activemq.command.ActiveMQQueue">
            <constructor-arg>
                <!-- 目的地的名字 -->
                <value>queue</value>
            </constructor-arg>
        </bean>
        2):一对多配置
        <bean id="topicDestination" class="org.apache.activemq.command.ActiveMQTopic">
             <constructor-arg>
                 <value>topic</value>
             </constructor-arg>
         </bean>
         注意:这个queueDestination和topicDestination是在java类中注入使用的
    6）、定义消息监听器(监听消息生产者发送的消息),需要创建一个类需要实现MessageListener.
        <bean id="consumerMessageListener" class="com.rainbow.packge.jms.ConsumerMessageListener"/>
    7)、使用spring-jms提供的监听器容器工具类来管理监听器，需要传入三个参数
        1、监听对象，也就是spring管理的池connectionFactory
        2、目的地
        3、消息监听器
        <bean id="jmsContainer" class="org.springframework.jms.listener.DefaultMessageListenerContainer">
            <property name="connectionFactory" ref="connectionFactory" />
            <property name="destination" ref="queueDestination" />
            <property name="messageListener" ref="consumerSessionAwareMessageListener" />
        </bean>