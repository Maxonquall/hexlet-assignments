package exercise;


class SafetyList {
    // BEGIN
    private int[] array = new int[0];

    public SafetyList(int[] array) {
        this.array = array;
    }

    public SafetyList() {
    }

    public synchronized void add(int value) {
        var newArray = new int[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = value;
        array = newArray;
    }

    public int get(int value) {
        return array[value];
    }

    public int getSize() {
        return array.length;
    }

    // END
}
