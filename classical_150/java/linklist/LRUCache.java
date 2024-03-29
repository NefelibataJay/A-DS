package classical_150.java.linklist;

import java.util.*;

public class LRUCache {
  class DLinkNode {
    int value;
    int key;
    DLinkNode pre;
    DLinkNode next;

    public DLinkNode() {
    }

    public DLinkNode(int _key, int _value) {
      key = _key;
      value = _value;
    }
  }

  int capacity;
  HashMap<Integer, DLinkNode> dataMap;
  DLinkNode head;
  DLinkNode tail;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.dataMap = new HashMap<>(capacity);
    head = new DLinkNode();
    tail = new DLinkNode();
    head.next = tail;
    tail.pre = head;
  }

  public int get(int key) {
    if (!this.dataMap.containsKey(key))
      return -1;

    DLinkNode node = dataMap.get(key);
    this.move2Head(node); // 移动该节点到双向链表最前面
    return node.value;
  }

  public void put(int key, int value) {
    if (dataMap.containsKey(key)) {
      DLinkNode node = dataMap.get(key);
      node.value = value;
      move2Head(node);
    } else {
      // 不包含key
      if (dataMap.size() >= this.capacity) {
        // 删除最久没使用过的元素
        DLinkNode last = this.removeTail();
        dataMap.remove(last.key);
      }

      DLinkNode newNode = new DLinkNode(key, value);
      add2Head(newNode);
      dataMap.put(key, newNode);
    }
  }

  private DLinkNode removeTail() {
    DLinkNode res = tail.pre;
    this.removeNode(res);
    return res;
  }

  private void move2Head(DLinkNode node) {
    // 移动该节点到头部， 先删除该节点原先的位置
    this.removeNode(node);
    // 然后再吧这个节点添加到头节点后面
    this.add2Head(node);
  }

  private void add2Head(DLinkNode node) {
    node.pre = head;
    node.next = head.next;
    node.next.pre = node;
    head.next = node;
  }

  private void removeNode(DLinkNode node) {
    node.next.pre = node.pre;
    node.pre.next = node.next;
  }
}

class LRUCache1 extends LinkedHashMap<Integer, Integer> {
  private int capacity;

  public LRUCache1(int capacity) {
    super(capacity, 0.75F, true);
    this.capacity = capacity;
  }

  public int get(int key) {
    return super.getOrDefault(key, -1);
  }

  public void put(int key, int value) {
    super.put(key, value);
  }

  @Override
  protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
    return size() > capacity;
  }
}