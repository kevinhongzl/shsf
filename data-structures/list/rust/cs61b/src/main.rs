struct Node {
    item: i32,
    next: Option<Box<Node>>,
}

impl Node {
    fn new(x: i32, next: Option<Box<Node>>) -> Node {
        Node {
            item: x,
            next: next,
        }
    }
}

struct SLList {
    sentinel: Box<Node>,
    size: usize,
}

impl SLList {
    fn new() -> SLList {
        SLList {
            sentinel: Box::new(Node {
                item: 0,
                next: None,
            }),
            size: 0,
        }
    }

    fn add_first(&mut self, x: i32) {
        self.size += 1;
        self.sentinel.next = Some(Box::new(Node {
            item: x,
            next: self.sentinel.next.take(),
        }));
    }

    fn get_first(&self) -> Option<i32> {
        match &self.sentinel.next {
            Some(node) => Some(node.item),
            None => None,
        }
    }

    fn get(&self, index: usize) -> Option<i32> {
        if index >= self.size {
            return None;
        }
        let mut p = self.sentinel.next.as_ref().unwrap();
        for _i in 0..index {
            p = p.next.as_ref().unwrap();
        }
        Some(p.item)
    }

    fn insert(&mut self, index: usize, x: i32) {
        let mut p = &mut self.sentinel;
        let mut i = 0;
        while i < index && p.next.is_some() {
            p = p.next.as_mut().unwrap();
            i += 1;
        }
        p.next = Some(Box::new(Node {
            item: x,
            next: p.next.take(),
        }));
        self.size += 1;
    }

    // remove
}

fn main() {
    let node = Node::new(12, None);
    println!("{}", node.item);

    let mut list = SLList::new();
    list.insert(0, 112);
    list.insert(1, 14);
    list.insert(2, 134);
    println!("{:?}", list.get(1));
}
