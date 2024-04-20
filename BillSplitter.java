public class BillSplitter {

    // The method split returns a list of all the costs of all the items
    // that I have to pay for only if it exists. If it doesn't then we return null.
    // We take in 2 parameters, 'in' that is a list of all the item costs left to consider
    // and target which is the total of what I have to pay for.
    public static UniqueOrderedList<Integer> split(UniqueOrderedList<Integer> in, int target) {
        // If there's nothing left to consider then we simply return null.
        if (in == null) { return null; }
        // Otherwise we initialize an iterator that iterates over while traversing
        // over the list of integers 'in', which represents item costs.
        CopyableIterator<Integer> itemIterator = in.iterator();
        // Calling in the private method to find the split.
        return mySplit(itemIterator, target);
    }

    // This method recursively finds a valid way to split the bill.
    // This method explores two possibilities for each item:
    //  a) I pay for it.
    //  b) My friend pays for it.
    // It recursively tries both options.
    private static UniqueOrderedList<Integer> mySplit(CopyableIterator<Integer> itemIterator, int target) {

        // Checking if there are more elements to iterate over.
        if (!itemIterator.hasNext()) {
            // If none, then we already have our target with the current combination.
            if (target == 0) { return new UniqueOrderedList<>(); }
            // However if the target wasn't reached then we return null.
            else { return null; }
        }
        // Getting the current item cost pointed by iterator.
        int currValue = itemIterator.next();
        // Option 1: Including the current item in my share.
        UniqueOrderedList<Integer> withCurr = mySplit(itemIterator.copy(), target - currValue); // As shown in pseudocode.
        if (withCurr != null) {
            // If including current items cost leads to a valid split then we add it to the list.
            withCurr.add(currValue);
            return withCurr;
        }
        // Option 2: Exclude it from my share and add it to my friends.
        return mySplit(itemIterator, target); // Continuing the recursive call with the current item assigned to my friend.
    }

}
