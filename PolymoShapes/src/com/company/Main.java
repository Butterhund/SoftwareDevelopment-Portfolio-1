package com.company;

public class Main {


    public static void main(String[] args) {
       // Rect rect1 = new Rect(4, 8);
       // Rect rect2 = new Rect(4, 8);
       // Circle circle1 = new Circle(2);
        Triangle tri1 = new Triangle(0, 0,3,0,3,3);
        tri1.printArea();
        tri1.pointWithin(2,3);
        tri1.pointPrint();
        tri1.getCenter();
       /* rect1.printCenter(2,4);
        rect2.printCenter(2,4);
        rect1.getArea();
        rect1.getCirc();
        rect1.pointWithin(4,4);
        rect1.pointPrint();
        euclidDistance(rect1.x, rect1.y, rect2.x, rect2.y);*/

    }
    //a method that euclidean.
    static void euclidDistance(int shape1x, int shape1y, int shape2x, int shape2y) {
        int x1 = shape1x;
        int y1 = shape1y;
        int x2 = shape2x;
        int y2 = shape2y;
        // calculate the distance between the two points.
        int dist = (int) Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
        System.out.println("The distance between the centers of the two shapes is " + dist);
    }
}



abstract class Shape {

    int x;
    int y;
    int area;
    int circ;
    boolean pointInside = true;
    String name = "shape";

    //A method that prints the center point of all shapes, except triangles.
    void setCenter(int xPos,int yPos) {
        this.x = xPos;
        this.y = yPos;
        System.out.println("Center of " + this.name + " is (" + x + "," + y + ").");
    }

    //A method that calculates the area of a shape.
    void getArea() {
        System.out.println("The area of " + this.name + " is " + this.area);
    }

    //A method that calculates the circumference of a shape.
    void getCirc() {
        System.out.println("The circumference of " + this.name + " is " + this.circ);
    }

    //A method that calculates if a given point is inside a shape.
    void pointPrint() {
        if(pointInside == true) {
            System.out.println("The point is inside the " + this.name);
        } else {
            System.out.println("The point is not inside the " + this.name);
        }
    }
}
//Rectangle class
class Rect extends Shape {
    int height;
    int width;
    //Create a class constructor

    Rect(int height,int width) {
        this.height = height;
        this.width = width;
        this.name = "rect";
        this.area = height * width;
        this.circ = height * 2 + width * 2;
        this.x = x;
        this.y = y;

    }

    //a method that returns the boolean either false or true.
    void pointWithin(int xPoint, int yPoint) {
        if(xPoint > this.x - this.width/2 && xPoint < this.x + this.width/2) {
            if(yPoint > this.y - this.height/2 && yPoint < this.y + this.height/2) {
                pointInside = true;
            }
        } else {
            pointInside = false;
        }
    }

}

//Circle class
class Circle extends Shape {
    int diameter;
    int radius;
    //Constructor

    Circle(int diameter, int x) {
        this.diameter = diameter;
        this.name = "circle";
        this.radius = diameter/2;
        this.area = (int) (Math.PI * radius * radius);
        this.circ = (int) (diameter * Math.PI);

    }

    //a method that returns the boolean either false or true. Checks if a given point is inside the circle.
    void pointWithin(int xPoint, int yPoint) {
        int dist = (int) Math.sqrt((yPoint - this.y) * (yPoint - this.y) + (xPoint - this.x) * (xPoint - this.x));
            if(dist <= this.radius) {
                pointInside = true;
            } else {
            pointInside = false;
        }
    }

}
class Triangle extends Shape {
    double xA;
    double yA;
    double xB;
    double yB;
    double xC;
    double yC;
    double areas;


    //Constructor
    Triangle(double xa, double ya, double xb, double yb, double xc, double yc) {
        this.xA = xa;
        this.yA = ya;
        this.xB = xb;
        this.yB = yb;
        this.xC = xc;
        this.yC = yc;

        //Calculation of area, using the three points.
        this.areas = Math.abs((xA *(yB - yC) + xB *(yC - yA) + xC *(yA - yB))/2);

    }
    void printArea() {
        System.out.println("The area of the triangle is: " + this.areas);
    }

    //a method that returns the boolean either false or true. Checks if a given point is inside the triangle.
    void pointWithin(int xPoint, int yPoint) {
        double a1 = Math.abs((xPoint *(yB - yC) + xB *(yC - yPoint) + xC *(yPoint - yB))/2);
        double a2 = Math.abs((xA *(yPoint - yC) + xPoint *(yC - yA) + xC *(yA - yPoint))/2);
        double a3 = Math.abs((xA *(yB - yPoint) + xB *(yPoint - yA) + xPoint *(yA - yB))/2);
        double A = a1 + a2 + a3;
        if(A == this.areas) {
            pointInside = true;
        } else {
            pointInside = false;
        }
    }
    //Get center of a triangle
    void getCenter() {
        double xCenter = (this.xA + this.xB + this.xC)/3;
        double yCenter = (this.yA + this.yB + this.yC)/3;
        System.out.println("Center of the triangle is = " + "(" + xCenter + ", " + yCenter + ")");
    }
}