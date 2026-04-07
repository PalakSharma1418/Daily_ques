// Last updated: 4/7/2026, 7:43:33 PM
1class Robot {
2
3    int idx = 0;
4    boolean moved = false;
5    List<int[]> pos = new ArrayList<>(); // {x, y, dir}
6    public Robot(int width, int height) {
7
8        // Bottom row (left to right) - East (0)
9        for (int x = 0; x < width; x++) {
10            pos.add(new int[]{x, 0, 0});
11        }
12
13        // Right column (bottom to top) - North (1)
14        for (int y = 1; y < height; y++) {
15            pos.add(new int[]{width - 1, y, 1});
16        }
17
18        // Top row (right to left) - West (2)
19        for (int x = width - 2; x >= 0; x--) {
20            pos.add(new int[]{x, height - 1, 2});
21        }
22
23        // Left column (top to bottom) - South (3)
24        for (int y = height - 2; y > 0; y--) {
25            pos.add(new int[]{0, y, 3});
26        }
27
28        // Handle corner case for (0,0) after movement
29        pos.get(0)[2] = 3;
30    }
31
32    public void step(int num) {
33        moved = true;
34        idx = (idx + num) % pos.size();
35    }
36
37    public int[] getPos() {
38        return new int[]{pos.get(idx)[0], pos.get(idx)[1]};
39    }
40
41    public String getDir() {
42        if (!moved) return "East";
43
44        int d = pos.get(idx)[2];
45
46        if (d == 0) return "East";
47        else if (d == 1) return "North";
48        else if (d == 2) return "West";
49        return "South";
50    }
51}