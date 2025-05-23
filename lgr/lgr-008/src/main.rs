fn main() {
    let a: i32 = 5;
    
    // if-else 
    if a > 5 {
        println!("bigger than 5");
    } else if a > 3 {
        println!("bigger than 3");
    } else {
        println!("small or equal to 3");
    }

    let b: i32 = if a > 5 { 1 } else { -1 };
    println!("{b}");

    // loop
    'outer: loop {
        println!("loop forever");
        loop {
            break 'outer;
        }
    }

    let x = loop {
        break 5;
    };
    println!("{x}");

    // while loop
    let mut a = 0;
    while a < 5 {
        println!("a is {a}");
        a = a + 1; 
    }

    // for loop
    let a: [i32; 5] = [1, 2, 3, 4, 5];
    for element in a {
        println!("{}", element);
    }
}
