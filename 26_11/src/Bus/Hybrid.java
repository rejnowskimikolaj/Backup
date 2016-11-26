package Bus;

public class Hybrid extends Bus implements LiquidFuel,Electric {

	@Override
	public int getVoltage() {
		return Electric.HIGH_VOLTAGE-Electric.LOW_VOLTAGE;
	}

	@Override
	public int getRange() {
		return 0;
	}

	@Override
	public int getEmissionTier() {
		return 0;
	}

	

}
