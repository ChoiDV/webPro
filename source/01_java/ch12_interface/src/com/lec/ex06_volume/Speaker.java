package com.lec.ex06_volume;
// Speaker s = new Speaker(45);
// s.volumeDown(10)
public class Speaker implements IVolume{
	private static final byte SPEAKER_MAX_VOLUME = 100;
	private static final byte SPEAKER_MIN_VOLUME = 0;
	private int volumeLevel;
	public Speaker() {}
	public Speaker(int volumeLevel) {
		this.volumeLevel = volumeLevel;
	}
	@Override
	public void volumeUp() {
		if(volumeLevel < SPEAKER_MAX_VOLUME) {
			volumeLevel ++;
			System.out.println("스피커 볼륨을 1올려 현재 "+volumeLevel);
		}else {
			System.out.println("스피커 볼륨이 최대치여서 올리지 못했습니다");
		}
	}
	@Override
	public void volumeUp(int level) {
		if(volumeLevel + level <= SPEAKER_MAX_VOLUME) { // level만큼 볼륨 올림
			volumeLevel += level; //volumeLevel = volumeLevel + level;
			System.out.println("스피커 볼륨을 "+level+"올려 현재 "+volumeLevel);
		}else { // level만큼 못 올릴 경우 ex. 현재 볼륨 45 level 10 => 몇만큼 올릴지 계산(5),  볼륨은 50
			int tempLevel = SPEAKER_MAX_VOLUME - volumeLevel; 
			volumeLevel = SPEAKER_MAX_VOLUME;
			System.out.println("스피커 볼륨을 "+level+"만큼 못 올리고 "+tempLevel+"만큼 올려 최대치 "+SPEAKER_MAX_VOLUME);
		}// if
	}
	@Override
	public void volumeDown() {
		if(volumeLevel > SPEAKER_MIN_VOLUME) {// volumeLevel을 내릴 수 있는 경우
			volumeLevel -- ;
			System.out.println("스피커 볼륨을 1내려 현재 "+volumeLevel);
		}else {// volumeLevel이 최소치여서 못 내리는 경우
			System.out.println("스피커 볼륨이 최소치여서 내리지 못했습니다");
		}
	}
	@Override
	public void volumeDown(int level) {
		if(volumeLevel - level >= SPEAKER_MIN_VOLUME) { // level만큼 볼륨 내림
			volumeLevel -= level; //volumeLevel = volumeLevel - level;
			System.out.println("스피커 볼륨을 "+level+"내려 현재 "+volumeLevel);
		}else { // level만큼 못 내릴 경우 ex. 현재 볼륨 5 level 10 => 몇만큼 내릴지 계산(5),  볼륨은 0으로
			int tempLevel = volumeLevel - SPEAKER_MIN_VOLUME; 
			volumeLevel = SPEAKER_MIN_VOLUME;
			System.out.println("스피커 볼륨을 "+level+"만큼 못 내리고 "+tempLevel+"만큼 내려 최소치 "+SPEAKER_MIN_VOLUME);
		}// if
	}
}













