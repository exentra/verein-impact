import { defineStore } from 'pinia';

export const useInvoicesStore = defineStore('open-invoices', {
  state: () => ({
    invoices: [
      {
        'invoiceNumber': 123,
        'date': '2022-10-23T17:31:00.000Z',
        'biller': 'LaPerla Pizzeria-Pasta-Salate',
        'customerId': '1234-2',
        'invoiceAddress': 'Regebogenstraße 18',
        'totalBruttoAmount': 34.00,
        'totalNettoAmount': 32.38,
        'description': 'Random text, v.a. für Notizen',
        'invoiceItems': [
          {
            'position': '1',
            'description': 'Spaghetti Carbonara',
            'count': 2.0,
            'nettoPrice': 14.02,
            'bruttoPrice': 15.0,
            'tax': 0.07
          },
          {
            'position': '2',
            'description': 'Pizza Margherita',
            'count': 1.0,
            'nettoPrice': 6.07,
            'bruttoPrice': 6.5,
            'tax': 0.07
          },
          {
            'position': '3',
            'description': 'Pizza Diavola',
            'count': 1.0,
            'nettoPrice': 7.47,
            'bruttoPrice': 8.0,
            'tax': 0.07
          },
          {
            'position': '4',
            'description': 'Pizza Pane',
            'count': 1.0,
            'nettoPrice': 4.20,
            'bruttoPrice': 4.5,
            'tax': 0.07
          }
        ]
      },
      {
        'invoiceNumber': 125,
        'date': '2022-10-23T17:31:00.000Z',
        'biller': 'asdfgjasdg Pizzeria-Pasta-Salate',
        'customerId': '1232-2',
        'invoiceAddress': 'Regebogenstraße 18',
        'totalBruttoAmount': 33.00,
        'totalNettoAmount': 12.38,
        'description': 'Random text, v.a. für Notizen',
        'invoiceItems': [
          {
            'position': '1',
            'description': 'Spaghetti Carbonara',
            'count': 2.0,
            'nettoPrice': 14.02,
            'bruttoPrice': 15.0,
            'tax': 0.07
          },
          {
            'position': '2',
            'description': 'Pizza Margherita',
            'count': 1.0,
            'nettoPrice': 6.07,
            'bruttoPrice': 6.5,
            'tax': 0.07
          },
          {
            'position': '3',
            'description': 'Pizza Diavola',
            'count': 1.0,
            'nettoPrice': 7.47,
            'bruttoPrice': 8.0,
            'tax': 0.07
          },
          {
            'position': '4',
            'description': 'Pizza Pane',
            'count': 1.0,
            'nettoPrice': 4.20,
            'bruttoPrice': 4.5,
            'tax': 0.07
          }
        ]
      }
    ]
  }),
});
