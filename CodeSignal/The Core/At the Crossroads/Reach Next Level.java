boolean reachNextLevel(int experience, int threshold, int reward) {
    return threshold - experience <= reward;
}
