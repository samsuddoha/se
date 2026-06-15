//* Target Interface
interface MediaPlayer {
  play(audioType: string, fileName: string): void;
}
//?Adaptive/adaptee class
class Mp4Player {
  playMp4(fileName: string): void {
    console.log(`Playing mp4 file: ${fileName}`);
  }
}
//!Adapter class
class MediaAdapter implements MediaPlayer {
  private mp4Player = new Mp4Player();

  play(audioType: string, fileName: string): void {
    if (audioType.toLowerCase() === 'mp4') {
      this.mp4Player.playMp4(fileName);
    } else {
      throw new Error(`Invalid media type: ${audioType}`);
    }
  }
}
//Client Code:
const player: MediaPlayer = new MediaAdapter();
player.play('mp4', 'song.mp4');
