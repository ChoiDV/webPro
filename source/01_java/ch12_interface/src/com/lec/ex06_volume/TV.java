package com.lec.ex06_volume;
// TV tv = new TV(45);
// tv.volumeDown(10)
// 
public class TV implements IVolume{
	private static final byte TV_MAX_VOLUME = 50;
	private static final byte TV_MIN_VOLUME = 0;
	private int volumeLevel;
	public TV() {}
	public TV(int volumeLevel) {
		this.volumeLevel = volumeLevel;
	}
	@Override
	public void volumeUp() {
		if(volumeLevel < TV_MAX_VOLUME) {
			volumeLevel ++;
			System.out.println("TV 볼륨을 1올려 현재 "+volumeLevel);
		}else {
			System.out.println("TV 볼륨이 최대치여서 올리지 못했습니다");
		}
	}
	@Override
	public void volumeUp(int level) {
		if(volumeLevel + level <= TV_MAX_VOLUME) { // level만큼 볼륨 올림
			volumeLevel += level; //volumeLevel = volumeLevel + level;
			System.out.println("TV 볼륨을 "+level+"올려 현재 "+volumeLevel);
		}else { // level만큼 못 올릴 경우 ex. 현재 볼륨 45 level 10 => 몇만큼 올릴지 계산(5),  볼륨은 50
			int tempLevel = TV_MAX_VOLUME - volumeLevel; 
			volumeLevel = TV_MAX_VOLUME;
			System.out.println("TV 볼륨을 "+level+"만큼 못 올리고 "+tempLevel+"만큼 올려 최대치 "+TV_MAX_VOLUME);
		}// if
	}
	@Override
	public void volumeDown() {
		if(volumeLevel > TV_MIN_VOLUME) {// volumeLevel을 내릴 수 있는 경우
			volumeLevel -- ;
			System.out.println("TV 볼륨을 1내려 현재 "+volumeLevel);
		}else {// volumeLevel이 최소치여서 못 내리는 경우
			System.out.println("TV 볼륨이 최소치여서 내리지 못했습니다");
		}
	}
	@Override
	public void volumeDown(int level) {
		if(volumeLevel - level >= TV_MIN_VOLUME) { // level만큼 볼륨 내림
			volumeLevel -= level; //volumeLevel = volumeLevel - level;
			System.out.println("TV 볼륨을 "+level+"내려 현재 "+volumeLevel);
		}else { // level만큼 못 내릴 경우 ex. 현재 볼륨 5 level 10 => 몇만큼 내릴지 계산(5),  볼륨은 0으로
			int tempLevel = volumeLevel; 
			volumeLevel = TV_MIN_VOLUME;
			System.out.println("TV 볼륨을 "+level+"만큼 못 내리고 "+tempLevel+"만큼 내려 최소치 "+TV_MIN_VOLUME);
		}// if
	}
}













