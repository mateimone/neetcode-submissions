
class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Point origin = new Point(0, 0);
        PriorityQueue<Point> pq = new PriorityQueue<>( (p1, p2) -> Double.compare(distance(p2, origin), distance(p1, origin)) );
        
        // IntStream.range(0, points.length).forEach(i -> pq.offer(new Point(points[i][0], points[i][1])));
        
        int[][] res = new int[k][2];
        int j = 0;
        for (int i = 0;i < points.length;i++) {
            pq.offer(new Point(points[i][0], points[i][1]));
            if (pq.size() > k) {
                Point p = pq.poll();
                
            }
        }

        while(!pq.isEmpty()) {
            Point p = pq.poll();
            res[j++] = new int[]{p.x, p.y};
        }

        return res;
    }

    public double distance(Point p1, Point p2) {
        return Math.sqrt((p1.x-p2.x)*(p1.x-p2.x) + (p1.y-p2.y)*(p1.y-p2.y));
    }
}
