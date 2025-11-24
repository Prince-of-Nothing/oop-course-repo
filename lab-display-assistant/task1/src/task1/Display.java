package task1;
//it needs to be the same as the name
public class Display {

    private int width;//width in pixels , since it would be more accurate than cm or inches , we do not know the screen to body ratio
    private int height;//height in pixels
    private float ppi; //pixels per inch, this could be calculated if we had the display length and height in both pixels and inches or cm
    private String model;

    public Display(int width, int height, float ppi, String model) {
        this.width = width;
        this.height = height;
        this.ppi = ppi;
        this.model = model;
    }
    public void compareSize(Display m) {
    //How does one compare size ? by length and width , they could be different , but a 1440 × 1440 display is the same as a 1920 × 1080 display in terms of area by the number of pixels ...
    //Conclusion : calculate area to obtain the size
    }
    public void compareSharpness(Display m) {
    }
    public void compareWithMonitor(Display m) {
    }
}