class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int writeIndex = 0;
        
        for (int i = 0; i < asteroids.length; i++) {
            int current = asteroids[i];
            
            while (writeIndex > 0 && asteroids[writeIndex - 1] > 0 && current < 0 && asteroids[writeIndex - 1] < -current) {
                writeIndex--;
            }
            
            if (writeIndex == 0 || current > 0 || asteroids[writeIndex - 1] < 0) {
                asteroids[writeIndex++] = current;
            } else if (asteroids[writeIndex - 1] == -current) {
                writeIndex--;
            }
        }
        
        return Arrays.copyOf(asteroids, writeIndex);
    }
}