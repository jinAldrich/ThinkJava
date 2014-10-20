package com.yujin.demo.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.yujin.factory.Factory;

class Part {
	static List<Factory<? extends Part>> partFactories = new ArrayList<Factory<? extends Part>>();
	private static Random rand = new Random(47);
    static {
        partFactories.add(new FueFilter.Factory());
        partFactories.add(new AirFilter.Factory());
        partFactories.add(new CabinAirFilter.Factory());
        partFactories.add(new OilFilter.Factory());
        partFactories.add(new FanBelt.Factory());
        partFactories.add(new PowerSteeringBelt.Factory());
        partFactories.add(new GeneratorBelt.Factory());
    }
    
    public static Part createRandom() {
        int n = rand.nextInt(partFactories.size());
        System.out.println("n: " + n);
        return partFactories.get(n).create();
    }
    public String toString() {
    	return getClass().getSimpleName();
    }
}

class Filter extends Part {}

class FueFilter extends Filter {
    public static class Factory implements com.yujin.factory.Factory<FueFilter> {
    	public Factory() {
    		System.out.println("<---FueFilter-Factory-->");
    	}
        public FueFilter create() {
        	System.out.println("<---FueFilter-create-->");
            return new FueFilter();
        }
    }
}

class AirFilter extends Filter {
    public static class Factory implements com.yujin.factory.Factory<AirFilter> {
    	public Factory() {
    		System.out.println("<---AirFilter-Factory-->");
    	}
        public AirFilter create() {
        	System.out.println("<---AirFilter-create-->");
            return new AirFilter();
        }
    }
}

class CabinAirFilter extends Filter {
    public static class Factory implements com.yujin.factory.Factory<CabinAirFilter> {
    	public Factory() {
    		System.out.println("<---CabinAirFilter-Factory-->");
    	}
        public CabinAirFilter create() {
        	System.out.println("<---CabinAirFilter-create-->");
            return new CabinAirFilter();
        }
    }
}

class OilFilter extends Filter {
    public static class Factory implements com.yujin.factory.Factory<OilFilter> {
    	public Factory() {
    		System.out.println("<---OilFilter-Factory-->");
    	}
        public OilFilter create() {
        	System.out.println("<---OilFilter-create-->");
            return new OilFilter();
        }
    }
}

class Belt extends Part {}

class FanBelt extends Belt {
    public static class Factory implements com.yujin.factory.Factory<FanBelt> {
    	public Factory() {
    		System.out.println("<---FanBelt-Factory-->");
    	}
        public FanBelt create() {
        	System.out.println("<---FanBelt-create-->");
            return new FanBelt();
        }
    }
}

class GeneratorBelt extends Belt {
    public static class Factory implements com.yujin.factory.Factory<GeneratorBelt> {
    	public Factory() {
    		System.out.println("<---GeneratorBelt-Factory-->");
    	}
        public GeneratorBelt create() {
        	System.out.println("<---GeneratorBelt-create-->");
            return new GeneratorBelt();
        }
    }
}

class PowerSteeringBelt extends Belt {
    public static class Factory implements com.yujin.factory.Factory<PowerSteeringBelt> {
    	public Factory() {
    		System.out.println("<---PowerSteeringBelt-Factory-->");
    	}
        public PowerSteeringBelt create() {
        	System.out.println("<---PowerSteeringBelt-create-->");
            return new PowerSteeringBelt();
        }
    }
}


public class RegisteredFactories {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(Part.createRandom());
        }
    }
}
