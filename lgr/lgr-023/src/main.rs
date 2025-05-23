struct Product {
    name: String,
    category: ProductCategory,
    price: f32,
    in_stock: bool    
}

enum ProductCategory {
    Books,
    Clothing,
    Electrics
}

enum Command {
    Undo,
    AddText(String),
    MoveCursor(i32, i32),
    Replace {
        from: String,
        to: String
    }
}

impl Command {
    fn serialize(&self) -> String {
        String::from("JSON String")
    }
}

fn main() {
    
    // Example 1

    let category: ProductCategory = ProductCategory::Electrics;
    let product: Product = Product {
        name: String::from("TV"),
        category,
        price: 200.98,
        in_stock: true
    };

    // Example 2

    let cmd: Command = Command::Undo;
    let cmd: Command = Command::AddText(String::from("test"));
    let cmd: Command = Command::MoveCursor(22, 0);
    let cmd: Command = Command::Replace {
        from: String::from("a"),
        to: String::from("b"),
    };

    let json_string: String = cmd.serialize();
}