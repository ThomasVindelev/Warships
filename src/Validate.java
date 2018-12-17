public class Validate {

    public int validateNumber(String coordinate) {
        int coordinateNumber;
        try {
            coordinateNumber = Integer.parseInt(coordinate);
        } catch (NumberFormatException NFE) {
            coordinateNumber = -1;
        }
        return coordinateNumber;
    }

    public boolean validateLength(int x1, int y1, int x2, int y2, int length) {
        boolean isCorrectLength;
        length -= 1;
        if (x1 == x2 && y1 - length == y2) {
            isCorrectLength = true;
        } else if (x1 == x2 && y1 == y2 - length) {
            isCorrectLength = true;
        } else if (x1 - length == x2 && y1 == y2) {
            isCorrectLength = true;
        } else if (x1 == x2 - length && y1 == y2) {
            isCorrectLength = true;
        } else if (x1 == x2 && y1 + length == y2) {
            isCorrectLength = true;
        } else if (x1 == x2 && y1 == y2 + length) {
            isCorrectLength = true;
        } else if (x1 + length == x2 && y1 == y2) {
            isCorrectLength = true;
        } else if (x1 == x2 + length && y1 == y2) {
            isCorrectLength = true;
        } else {
            isCorrectLength = false;
        }
        return isCorrectLength;
    }

}
