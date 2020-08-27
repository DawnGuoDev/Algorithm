package hash;

import java.util.Random;

public class HashTable<K, V> {

    /**
     * 散列表默认长度
     */
    private static final int DEFAULT_INITAL_CAPACITY = 8;

    /**
     * 装载因子
     */
    private static final float LOAD_FACTOR = 0.75f;
    
    /**
     * 初始化散列表数组
     */
    private Entry<K, V>[] table;

    /**
     * 实际元素个数
     */
    private int size;

    static class Entry<K,V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
        
    }
    
    public HashTable() {
        this.table =  (Entry<K, V>[]) new Entry[this.DEFAULT_INITAL_CAPACITY];
    }

    /**
     * 散列函数
     */
    private int hash(Object key) {
        int h;
        return key == null ? 0 : ((h = key.hashCode()) ^ (h >>> 16)) & (this.table.length - 1);
    }

    /**
     * 往散列表插入数据
     */
    private void put(K key, V value) {
        int index = hash(key);  // 获取数据存放的位置
        Entry<K, V> e = this.table[index];

        // 遍历拉链，先看一下是不是已经存在的，如果存在则直接更新数据
        while (e != null) {
            if (e.key == key) {
                e.value = value;
                return;
            }
            e = e.next;
        }
        
        // 头插法
        this.table[index] = new Entry<>(key, value, e);
        this.size++;
        if (this.size > HashTable.LOAD_FACTOR * this.table.length) {
            this.resize();
        }
    }

    /**
     * 从散列表中获取 key 的 value
     */
    private V get(K key) {
        int index = hash(key); 
        Entry<K, V> e = this.table[index];

        while (e != null && e.key != key) {
            e = e.next;
        }
        
        if (e == null) {
            return  null;
        }
    
        return e.value;
    }

    /**
     * 从散列表中删除数据
     * Todo: 增加哨兵节点
     */
    private void remove(K key) {
        int index = hash(key);
        Entry<K, V> e = this.table[index];

        if (null == e) {
            return;
        }
        
        // 没有哨兵节点的话，需要先单独判断第一个节点的情况
        if (e.key == key) {
            this.table[index] = e.next;
            return;
        }

        // 之后遍历从第二节点的情况
        Entry<K, V> t = this.table[index].next;
        while (t != null) {
            if (t.key == key) {
                e.next = t.next;
                this.size --;
                return;
            }
            e = e.next;
            t = t.next;
        }

    }

    private void resize() {
        Entry<K, V>[] oldTable = this.table;
        this.table =  (Entry<K, V>[]) new Entry[oldTable.length * 2];
        
        this.size = 0;

        // 使用现成的 put() 方法
        for (int i = 0; i < oldTable.length; i++) {
            Entry<K, V> e = oldTable[i];
            while (e != null) {
                this.put(e.key, e.value);
                e = e.next;
            }
        }

        // 这种方式在时间复杂度上可能会更优，因为使用 put() 方法的话，还需要先遍历一波
        // for (int i = 0; i < oldTable.length; i++) {
        //     Entry<K, V> e = oldTable[i];
        //     while (e != null) {
        //         int index =  hash(e.key);
        //         this.table[index] = new Entry<>(e.key, e.value, this.table[index]);
        //         this.size ++;
        //         e = e.next;
        //     }
        // }

    }


    public static void main(String[] args) {
        HashTable<Integer, Integer> hash = new HashTable<>();
        Random r =  new Random();
        for (int i = 0; i < 10000; i++) {
            hash.put(i, i);
        }
        for (int i = 0; i < 10000; i++) {
            hash.get(i);
        }
    }
}