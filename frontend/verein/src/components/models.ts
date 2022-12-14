export interface Todo {
  id: number;
  content: string;
}

export interface Meta {
  totalCount: number;
}

export interface Invoice {
  id: number;
  totalAmount: number;
  currency: string;
  image: string;
  created: string;
  creatorId: number;
}
