fn main() {
    let mut s1 = String::from("Rust");
    let r1 = &s1;
    println!("s1 is {s1}"); // pass string itself
    println!("s1 is {r1}"); // pass reference
    print_string(r1);

    let r2 = &mut s1;
    // println!("s1 is {s1}"); // mutable borrow later used
    add_to_string(r2);
    println!("{s1}");

    let s2 = generate_string();
}

fn generate_string() -> String {
    let s = String::from("Ferris");
    // &s   // Dangling reference
    s
}

fn add_to_string (p1: &mut String) {
    p1.push_str(" is awesome.")
}

fn print_string(p1: &String) {
    println!("{p1}");
}