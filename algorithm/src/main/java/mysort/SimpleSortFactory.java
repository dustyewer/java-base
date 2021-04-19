package mysort;

public class SimpleSortFactory {
  public static Sort getSort(String name) {
    Sort sort = null;
    if ("Bubble".equals(name)) {
      return new BubbleSort();
    } else if ("Select".equals(name)) {
      return new SelectSort();
    } else if ("Insert".equals(name)) {
      return new InsertSort();
    } else if ("Merge".equals(name)) {
      return new MergeSort();
    } else if ("Heap".equals(name)) {
      return new HeapSort();
    } else if ("Shell".equals(name)) {
      return new ShellSort();
    } else if ("Quick".equals(name)) {
      return new QuickSort();
    } else {
      return null;
    }
  }
}
