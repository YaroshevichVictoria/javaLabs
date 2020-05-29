package com.company.utils.flowers.subtropical.bougainvillea;

import com.company.utils.flowers.subtropical.SubtropicalFlower;

public class BougainvilleaFlower extends SubtropicalFlower {
    private boolean isToxic;

    public BougainvilleaFlower() {
        super();
        isToxic = false;
    }

    public BougainvilleaFlower(String name, int length, float price, boolean isToxic) {
        super(name, length, price);
        this.isToxic = isToxic;
    }

    public boolean getIsToxic() {
        return this.isToxic;
    }
}
