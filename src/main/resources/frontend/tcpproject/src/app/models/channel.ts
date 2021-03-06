import { Subscription } from "./subscription";

export class Channel {
  id: number;
  name: string;
  direct: boolean;
  subscriptions: Subscription[];

  selectedChannel: number;

  constructor(){
    this.id = 2;
    this.name = "default;"
  }

  updateId(idNumber :number) {
    this.id=idNumber;
  }
}
