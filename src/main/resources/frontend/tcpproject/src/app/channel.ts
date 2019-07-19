export class Channel {
  id: number;
  name: string;

  selectedChannel: number;

  constructor(){
    this.selectedChannel = 2;
    this.name = "default;"
  }

  updateId(idNumber :number) {
    this.id=idNumber;
  }
}
