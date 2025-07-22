#[derive(Debug)]
struct BSTNode {
    value: i32,
    left: Option<Box<BSTNode>>,
    right: Option<Box<BSTNode>>,
}

impl BSTNode {
    fn new(value: i32) -> Self {
        BSTNode {
            value: value,
            left: None,
            right: None,
        }
    }

    fn insert(&mut self, value: i32) {
        let branch = if value <= self.value {
            &mut self.left
        } else {
            &mut self.right
        };
        match branch {
            None => {
                *branch = Some(Box::new(BSTNode::new(value)));
            }
            Some(node) => {
                node.insert(value);
            }
        }
    }

    fn contain(&self, value: i32) -> bool {
        if self.value == value {
            true
        } else if self.value > value {
            match &self.left {
                None => false,
                Some(node) => node.contain(value)
            }
        } else {
             match &self.right {
                None => false,
                Some(node) => node.contain(value)
            }
        }
    }

    fn preorder(&self) {
        print!("{} ", self.value);
        self.left.as_ref().map(|node| {
            node.preorder();
        });
        self.right.as_ref().map(|node| {
            node.preorder();
        });
    }
}

fn main() {
    let mut tree = BSTNode::new(4);
    tree.insert(2);
    tree.insert(1);
    tree.insert(3);
    tree.insert(5);
    tree.insert(6);
    tree.insert(7);
    tree.preorder();
    println!("\nTree contains 1 : {}", tree.contain(1));
    println!("Tree contains 0 : {}", tree.contain(0));
}
