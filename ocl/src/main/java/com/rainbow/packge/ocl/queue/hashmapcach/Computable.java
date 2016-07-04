package com.rainbow.packge.ocl.queue.hashmapcach;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaojc on 2015/9/16.
 */
public interface Computable<A,V> {
    V compute(A arg) throws InterruptedException;
}

class ExpensiveFunction implements Computable<String, BigInteger>{

    @Override
    public BigInteger compute(String arg) throws InterruptedException {

        return new BigInteger(arg);
    }
}

class  Memoizer1<A,V> implements Computable<A,V>{

    private final Map<A,V> cache = new HashMap<A, V>();
    private final Computable<A,V> c;

    Memoizer1(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public synchronized V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null){
            result = c.compute(arg);
            cache.put(arg,result);
        }

        return result;
    }
}
