class Per implements Comparable<Per> {
    int position, speed;
    public Per(int p, int s) {
        position = p;
        speed = s;
    }

    @Override
    public int compareTo(Per other) {
        return position < other.position ? 1 : position == other.position ? 0 : -1;
    }

    public String toString() {
        return "(" + position + ", " + speed + ")";
    }
}

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Per[] pairs = new Per[position.length];
        for (int i = 0;i < position.length;i++) {
            pairs[i] = new Per(position[i], speed[i]);
        }

        Arrays.sort(pairs);
        ArrayDeque<Float> stack = new ArrayDeque<>();

        for (Per p: pairs) {
            float timeToTarget = (target - p.position) / (float) p.speed;
            if (stack.isEmpty()) {
                stack.add(timeToTarget);
            }
            else {
                float top = stack.getLast();
                if (timeToTarget > top) {
                    stack.add(timeToTarget);
                }
            }
        }

        return stack.size();
    }
}
