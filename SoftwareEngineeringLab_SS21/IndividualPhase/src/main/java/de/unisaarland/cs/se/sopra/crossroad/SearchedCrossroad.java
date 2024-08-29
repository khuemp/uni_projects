package de.unisaarland.cs.se.sopra.crossroad;

import java.util.List;

public class SearchedCrossroad extends Crossroad {

    private final int locId;

    public SearchedCrossroad(final int id, final CrossroadType type,
                             final List<Consequence> consequences, final int locId) {
        super(id, type, consequences);
        this.locId = locId;
    }

    @Override
    public boolean hasLoc() {
        return true;
    }

    @Override
    public int getLocId() {
        return locId;
    }
}
