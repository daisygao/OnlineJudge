class LRUCache{
public:
    struct ListNode {
        int key;
        int val;
        ListNode *next = NULL;
        ListNode *prev = NULL;
        ListNode(int k, int v) : key(k), val(v) {}
    };
    
    ListNode *head, *tail;
    unordered_map<int, ListNode*> map;
    int capacity_;
    LRUCache(int capacity) {
        head = tail = NULL;
        capacity_ = capacity;
    }
    
    void moveToHead(ListNode *node) {
        if (node == head) return;
        if (!head) {
            head = tail = node;
            node->next = node;
            node->prev = node;
        } else if (node == tail) {
            head = tail;
            tail = tail->prev;
        } else {
            if (node->prev) node->prev->next = node->next;
            if (node->next) node->next->prev = node->prev;
            node->next = head;
            head->prev = node;
            head = node;
            node->prev = tail;
            tail->next = node;
        }
    }
    int get(int key) {
        if (map.find(key) == map.end()) return -1;
        moveToHead(map[key]);
        return map[key]->val;
    }
    
    void set(int key, int value) {
        if (map.find(key) == map.end()) {
            if (map.size() == capacity_) {
                map.erase(tail->key);
                tail->val = value;
                tail->key = key;
                map[key] = tail;
            } else {
                map[key] = new ListNode(key, value);
            }
        } else {
            map[key]->val = value;
        }
        
        moveToHead(map[key]);
    }
};
