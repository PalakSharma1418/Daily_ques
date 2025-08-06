// Last updated: 8/6/2025, 4:43:51 PM
class Solution {
    public List<String> findAllRecipes(String[] recipes,List<List<String>> ingredients,String[] supplies
    ) {
        List<String> possibleRecipes = new ArrayList<>();
        Map<String, Boolean> canMake = new HashMap<>();
        Map<String, Integer> recipeToIndex = new HashMap<>();
        for (String supply : supplies) {
            canMake.put(supply, true);
        }
        for (int idx = 0; idx < recipes.length; idx++) {
            recipeToIndex.put(recipes[idx], idx);
        }
        for (String recipe : recipes) {
            checkRecipe(recipe,ingredients,new HashSet<String>(),canMake,recipeToIndex);
            if (canMake.get(recipe)) {
                possibleRecipes.add(recipe);
            }
        }

        return possibleRecipes;
    }

    private void checkRecipe(String recipe,List<List<String>> ingredients,Set<String> visited,Map<String, Boolean> canMake,Map<String, Integer> recipeToIndex) {
        if (canMake.containsKey(recipe) && canMake.get(recipe)) {
            return;
        }
        if (!recipeToIndex.containsKey(recipe) || visited.contains(recipe)) {
            canMake.put(recipe, false);
            return;
        }
        visited.add(recipe);
        List<String> neededIngredients = ingredients.get(recipeToIndex.get(recipe));
        for (String ingredient : neededIngredients) {
            checkRecipe(ingredient,ingredients,visited,canMake,recipeToIndex);
            if (!canMake.get(ingredient)) {
                canMake.put(recipe, false);
                return;
            }
        }
        canMake.put(recipe, true);
    }
}