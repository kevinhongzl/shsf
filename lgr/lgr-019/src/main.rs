use unicode_segmentation::UnicodeSegmentation;

fn main() {
    let mut s: String = String::from("foo");
    s.push_str("bar");
    println!("{}", s);
    s.replace_range(.., "baz");
    println!("{}", s);

    let s1: String = String::from("Hello, ");
    let s2: String = String::from("world!");
    let s3: String = s1 + &s2;
    println!("{}", s3);

    let s1: String = String::from("tic");
    let s2: String = String::from("tac");
    let s3: String = String::from("toe");
    let s = format!("{}-{}-{}", s1, s2, s3);
    println!("{}", s);

    let s: String = ["first", "second"].concat();
    let s: String = format!("{}{}", "first", "second");
    let s: &str = concat!("first", "second");
    println!("{}", s);

    let s1: &str = "🦀the🦀🦀🦀";
    let s2: &str = &s1[0..5];
    println!("{}", s2);

    for b in "नमस्ते".bytes() {  // namaste
        println!("{}", b);
    }

    for c in "नमस्ते".chars() {  // namaste
        println!("{}", c);
    }

    for g in "नमस्ते".graphemes(true) {  // namaste
        println!("{}", g);
    }

}
