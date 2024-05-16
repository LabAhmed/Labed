public class MagazzinoSmartphone {
    private Smartphone[] smartphones;
    private int count;

    public MagazzinoSmartphone() {
        smartphones = new Smartphone[10]; // Assuming initial capacity of 10
        count = 0;
    }

    public MagazzinoSmartphone(MagazzinoSmartphone other) {
        smartphones = new Smartphone[10];
        for (int i = 0; i < other.count; i++) {
            smartphones[i] = new Smartphone(other.smartphones[i]);
        }
        this.count = other.count;
    }


    public void addSmartphone(Smartphone smartphone) {
        if (smartphone !=null) {
            smartphones[count] = new Smartphone(smartphone);
            count++;
        }
    }

    public void removeSmartphone(Smartphone smartphone) {
        int i=0;
        boolean trovato = false;
        while (i<count && trovato == false) {
            if (smartphones[i].equals(smartphone)) {
                smartphones[i] = null;
                trovato=true;
            }
            i++;
        }
        if (trovato==true) {
            for (int j = i; j <count; j++) {
                smartphones[j-1] = smartphones[j];
            }
            smartphones[count-1] = null;
            count--;
        }
    }

    public Smartphone[] getSmartphonesArray() {
        Smartphone[] smartphoneArray = new Smartphone[count];
        System.arraycopy(smartphones, 0, smartphoneArray, 0, count);
        return smartphoneArray;
    }


    public Smartphone getSmartphoneByBrand(String brand) {
        Smartphone smartphone = null;
        int i=0;
        boolean trovato =false;
        while (i<count && trovato==false) {
            if (smartphones[i].getBrand().equalsIgnoreCase(brand)) {
                smartphone = new Smartphone(smartphones[i]);
                trovato = true; 
            }
        }
        return smartphone;
    }

    public MagazzinoSmartphone getSmartphonesByStorageCapacity(int storageCapacity) {
        MagazzinoSmartphone magazzinoSmartphone = new MagazzinoSmartphone();
        for (int i = 0; i < count; i++) {
            if (smartphones[i].getStorageCapacity() == storageCapacity) {
                magazzinoSmartphone.addSmartphone(smartphones[i]);
            }
        }
        return magazzinoSmartphone;
    }

    public MagazzinoSmartphone getSmartphonesByPriceRange(double minPrice, double maxPrice) {
        MagazzinoSmartphone magazzinoSmartphone = new MagazzinoSmartphone();
        for (int i = 0; i < count; i++) {
            if (smartphones[i].getPrice() <= maxPrice && smartphones[i].getPrice() >= minPrice) {
                magazzinoSmartphone.addSmartphone(smartphones[i]);
            }
        }
        return magazzinoSmartphone;
    }

    @Override
    public String toString() {
        String result = "\nMagazzinoSmartphone:\n";
        for (int i = 0; i < count; i++) {
            result +=smartphones[i]+"\n";
        }
        return result;
    }

    public int getCount() {
        return count;
    }

    public boolean equals(Object obj) {
       if (this != obj) {
        if (obj instanceof MagazzinoSmartphone) {
            MagazzinoSmartphone m = (MagazzinoSmartphone) obj;
            int i = 0;
            boolean ugualianza= true;
            while (i<count && ugualianza==true) {
                if(!this.smartphones[i].equals(m.smartphones[i])){
                    ugualianza = false;
                    return false;
                }else{
                    i++;
                }
            }
        }else{
            return false;
        }
       }

       return true;
    }


}