export class Message {
  id: number;
  private userId: number;
  private channelId: number;
  body: string;
  fromUsername: string;


  constructor() {

    this.userId = 2;
    this.fromUsername = "corby";
    this.channelId = 2;
  }


  updateChannelId(value: number) {
    this.channelId = value;
  }

}
