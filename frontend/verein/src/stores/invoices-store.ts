import { defineStore } from 'pinia';

export const useInvoicesStore = defineStore('invoices', {
  state: () => ({
    invoices: [{
      'id': 1,
      'totalAmount': 20.0,
      'currency': 'EURO',
      'image': 'sdjkfhsdkf437384hjbhsdjfsdf',
      'created': '2012-04-23T18:25:43.511Z',
      'creatorId': 1
    },
    {
      'id': 2,
      'totalAmount': 22.0,
      'currency': 'EURO',
      'image': 'sdfgasdg',
      'created': '2013-04-23T18:25:43.511Z',
      'creatorId': 1
    },
    ]
  }),
});
