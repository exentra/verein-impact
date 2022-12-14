import { defineStore } from 'pinia';

export interface InvoiceItem {
  position: string,
  description: string,
  count: number,
  nettoPrice: number,
  bruttoPrice: number,
  tax: number
}

export interface InvoiceContents {
  invoiceNumber: number,
  date: Date,
  biller: string | null,
  customerId: string | null,
  invoiceAddress: string | null,
  totalBruttoAmount: number,
  totalNettoAmount: number,
  description: string,
  invoiceItems: InvoiceItem[],
}

export interface InvoiceStore {
  image: string | null,
  contents: InvoiceContents | null,
}

export const useCounterStore = defineStore('invoice', {
  state: (): InvoiceStore => ({
    image: null,
    contents: null,
  }),
  getters: {
    image: (state) => state.image,
    contents: (state) => state.contents,
  },
  actions: {
    setImage(image: string) {
      this.image = image;
    },
    setContents(contents: InvoiceContents) {
      this.contents = contents;
    }
  },
});
