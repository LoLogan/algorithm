import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;


public class LRU {

//    private int currentCacheSize;
    private int CacheCapcity;
    private HashMap<String,CacheNode> caches;
    private CacheNode first;
    private CacheNode last;

    public LRU(int size){
//        currentCacheSize = 0;
        this.CacheCapcity = size;
        caches = new HashMap<String,CacheNode>(size);
    }

    public void put(String k,Integer v){
        CacheNode node = caches.get(k);
        if(node == null){
            if(caches.size() >= CacheCapcity){

                caches.remove(last.key);
                removeLast();
            }
            node = new CacheNode();
            node.key = k;
        }
        node.value = v;
        moveToFirst(node);
        caches.put(k, node);
    }

    public Object  get(String k){
        CacheNode node = caches.get(k);
        if(node == null){
            return null;
        }
        moveToFirst(node);
        return node.value;
    }

    public Object remove(String k){
        CacheNode node = caches.get(k);
        if(node != null){
            if(node.pre != null){
                node.pre.next=node.next;
            }
            if(node.next != null){
                node.next.pre=node.pre;
            }
            if(node == first){
                first = node.next;
            }
            if(node == last){
                last = node.pre;
            }
        }

        return caches.remove(k);
    }




    private void moveToFirst(CacheNode node){
        if(first == node){
            return;
        }
        if(node.next != null){
            node.next.pre = node.pre;
        }
        if(node.pre != null){
            node.pre.next = node.next;
        }
        if(node == last){
            last= last.pre;
        }
        if(first == null || last == null){
            first = last = node;
            return;
        }

        node.next=first;
        first.pre = node;
        first = node;
        first.pre=null;

    }

    private void removeLast(){
        if(last != null){
            last = last.pre;
            if(last == null){
                first = null;
            }else{
                last.next = null;
            }
        }
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        CacheNode node = first;
        while(node != null){
            sb.append(String.format("%s:%s ", node.key,node.value));
            node = node.next;
        }

        return sb.toString();
    }

    class CacheNode{
        CacheNode pre;
        CacheNode next;
        String key;
        Integer value;
        public CacheNode(){

        }
    }

    public static void main(String[] args) {

        LRU lru = new LRU(3);

        lru.put("a", 1);    // 1:a
        System.out.println(lru.toString());
        lru.put("b", 2);    // 2:b 1:a
        System.out.println(lru.toString());
        lru.put("c", 3);    // 3:c 2:b 1:a
        System.out.println(lru.toString());
        lru.put("d", 4);    // 4:d 3:c 2:b
        System.out.println(lru.toString());
        lru.put("aa", 5);   // 1:aa 4:d 3:c
        System.out.println(lru.toString());
        lru.put("bb", 6);   // 2:bb 1:aa 4:d
        System.out.println(lru.toString());
        lru.put("e", 7);    // 5:e 2:bb 1:aa
        System.out.println(lru.toString());
        lru.get("a");         // 1:aa 5:e 2:bb
        System.out.println(lru.toString());
        lru.remove("b");     // 1:aa 5:e 2:bb
        System.out.println(lru.toString());
        lru.remove("c");      //5:e 2:bb
        System.out.println(lru.toString());
        lru.put("aaa", 1);  //1:aaa 5:e 2:bb
        System.out.println(lru.toString());
    }

}