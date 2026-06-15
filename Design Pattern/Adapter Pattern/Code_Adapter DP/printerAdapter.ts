// targetiing intefrace
interface Printer {
  print(): void;
}
// Adaptee
class LeagacyPrinter {
  public printDocument(): void {
    console.log('Lagecy printer printing a document');
  }
}
// adapter
class PrinterAdapter implements Printer {
  private leagacyPrinter = new LeagacyPrinter();

  public print(): void {
    this.leagacyPrinter.printDocument();
  }
}
// client
const printer: Printer = new PrinterAdapter();
printer.print(); //?OUTPUT: Lagecy printer printing a document
