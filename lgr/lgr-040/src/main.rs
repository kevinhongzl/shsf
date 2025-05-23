struct VehicleInfo {
    make: String,
    model: String,
    year: u16
}

trait Park {
    fn park(&self);
}

trait Paint {
    fn paint(&self, color: String) {
        println!("painting object: {}", color);
    }
}

// Car

struct Car {
    info: VehicleInfo,
}

impl Park for Car {
    fn park(&self) {
        println!("parking car!")
    }
}

impl Paint for Car {}

// Truck

struct Truck {
    info: VehicleInfo,
}

impl Truck {
    fn unload(&self) {
        println!("unloading truck.")
    }
}

impl Park for Truck {
    fn park(&self) {
        println!("parking truck!")
    }
}

impl Paint for Truck {}

// House

struct House {}

impl Paint for House {
    fn paint(&self, color: String) {
        println!("painting house: {}", color);
    }
}


fn main() {
    let car = Car {
        info: VehicleInfo {
            make: String::from("Company A"),
            model: String::from("X"),
            year: 2000
        }
    };
    
    car.park();
    car.paint(String::from("green"));

    let truck = Truck {
        info: VehicleInfo {
            make: String::from("Company B"),
            model: String::from("Y"),
            year: 2010
        }
    };

    truck.unload();
    truck.park();
    truck.paint(String::from("blue"));

    let house = House {};
    
    house.paint(String::from("red"));
}
