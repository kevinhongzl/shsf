fn main() {
    let v: Vec<String> = Vec::new();
    
    let mut v = Vec::new();
    v.push(String::from("One"));
    v.push(String::from("Two"));
    v.push(String::from("Three"));

    let v2 = vec![1, 2, 3];

    let s: &String =  &v[0];
    // let s: String = v.remove(0); => safely remove elements

    let s: Option<&String> = v.get(0);
    if let Some(e) = s {
        println!("{e}");
    }

    for s in &mut v {
        s.push_str("!");
    }
    for s in &v {
        println!("{s}");
    }

    let mut v3 = vec![];
    for s in v { // for s in v.into_iter() 
        v3.push(s);
    } 
    // v is no longer valid after this for-loop called.
    // let i = v.get(0); => Error
}
