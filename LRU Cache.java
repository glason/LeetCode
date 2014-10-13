/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 */
public class LRUCache {
    HashMap<Integer,CacheEntry> hashMap;
    int capacity;
    CacheEntry head;
    CacheEntry tail;
    public LRUCache(int capacity) {
	this.capacity=capacity;
	hashMap=new HashMap<>();
	head=new CacheEntry(-1,-1);
	tail=new CacheEntry(1,1);
	head.next=tail;
	head.pre=null;
	tail.pre=head;
	tail.next=null;
    }
    public int get(int key) {
	if(hashMap.containsKey(key)){
	    CacheEntry e=hashMap.get(key);
	    moveToHead(e);
	    return e.v;
	}       
	return -1;
    }
    public void set(int key, int value) {
	if(hashMap.containsKey(key)){
	    CacheEntry e=hashMap.get(key);
	    e.v=value;
	    moveToHead(e);
	}else if(hashMap.size()<capacity){
	    CacheEntry e=new CacheEntry(key,value);
	    moveToHead(e);
	    hashMap.put(key,e);
	}else{
	    CacheEntry e=new CacheEntry(key,value);
	    int index=removeTail();
	    hashMap.remove(index);
	    moveToHead(e);
	    hashMap.put(key,e);
	}
    }
    private void moveToHead(CacheEntry e){
	if(e.pre!=null&&e.next!=null){
	    e.pre.next=e.next;
	    e.next.pre=e.pre;
	}
	e.next=head.next;
	e.pre=head;
	head.next.pre=e;
	head.next=e;
    }
    private int removeTail(){
	CacheEntry e=tail.pre;
	e.pre.next=tail;
	tail.pre=e.pre;
	e.pre=null;
	e.next=null;
	return e.k;
    }
    private class CacheEntry{
	int k;
	int v;
	CacheEntry pre;
	CacheEntry next;
	public CacheEntry(int k,int v){
	    this.k=k;
	    this.v=v;
	}
    }
}
