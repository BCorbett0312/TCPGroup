export class Subscription{
  id: number;
  userId: number;
  channelId: number;

  constructor(userId:number,channelId:number){
    this.userId=userId;
    this.channelId=channelId;
  }
}
