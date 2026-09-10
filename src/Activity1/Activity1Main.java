// Activity 1 - Question 2
// Creates two JFrames, each with one "click" button.
// Only MyFrame 1 is visible at start. Clicking its button swaps
// visibility to MyFrame 2, and clicking MyFrame 2's button swaps back.
public class Activity1Main {
    public static void main(String[] args) {
        MyFrame1 frame1 = new MyFrame1();
        MyFrame2 frame2 = new MyFrame2();

        frame1.setFrame2(frame2);
        frame2.setFrame1(frame1);

        // Only MyFrame 1 is visible when the program starts.
        frame1.setVisible(true);
    }
}
