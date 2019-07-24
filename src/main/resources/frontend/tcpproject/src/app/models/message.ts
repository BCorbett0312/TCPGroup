export class Message {
  id: number;
  fromUserId: number;
  private toChannelId: number;
  body: string;
  fromUsername: string;


  constructor() {

    this.fromUserId = 2;
    this.fromUsername = "corby";
    this.toChannelId = 2;
  }


  set channelId(value: number) {
    this.toChannelId = value;
  }
}
