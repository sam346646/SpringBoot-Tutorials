export class PointModule {

    //access modifier : private, public, protected
    x: number;
    y: number;
    private z: number;

    //constructor
    //where we cant have constructor overloading 
    //to solve this we can use '?' for parameters?
    constructor(x?: number, y?: number) {
        this.x = x;
        this.y = y;
    }

    // Shorthand to declare and initialize x and y no need of decalaring as above and initializing like this.x=x;
    // constructor(private x?: number,private y?:number) { }

    draw() {
        console.log(this.x + " " + this.y)
    }
}