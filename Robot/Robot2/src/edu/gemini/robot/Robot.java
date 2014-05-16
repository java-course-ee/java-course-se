package edu.gemini.robot;

public class Robot {
    
    private final static int STEP_ANGLE = 10;
    private final static int STEP_FORWARD = 1;

    public void turnLeft(int angle) {
        int fullAngle = 0;
        while(fullAngle<angle-STEP_ANGLE/2) {
            turnStepLeft();
            fullAngle += STEP_ANGLE;
        }
    }

    public void turnRight(int angle) {
        int fullAngle = 0;
        while(fullAngle<angle-STEP_ANGLE/2) {
            turnStepRight();
            fullAngle += STEP_ANGLE;
        }
    }

    private void turnStepLeft() {
        System.out.println("Turn LeftStep");
    }

    private void turnStepRight() {
        System.out.println("Turn RightStep");
    }

    public void forward(int distance) {
        int fullDistance = 0;
        while(fullDistance<distance-STEP_FORWARD/2) {
            forwardStep();
            fullDistance += STEP_FORWARD;
        }
    }

    private void forwardStep() {
        System.out.println("Forward Step");
    }
}
