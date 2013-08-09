/* 
给出n和n个整数，希望你从小到大给他们排序
*/

#include <iostream>
using namespace std;

int partition(int *arr, int start, int end) {
	int pivot = arr[end - 1], i = start - 1, j = start;
    while (j < end) {
        if (arr[j] <= pivot) {
        	int tmp = arr[j];
            arr[j] = arr[++i];
            arr[i] = tmp;
            if (j == end - 1) return i;
        }
        j++;
    }
}
void qsort(int *arr, int start, int end) {
    if (start + 1 < end) {
    	int pos = partition(arr, start, end);
        qsort(arr, start, pos);
        qsort(arr, pos + 1, end);
    }
}
int main() {
    int n;
    cin >> n;
    int *arr = new int[n], idx = 0;
    while (idx < n) {
        cin >> arr[idx++];
    }
    qsort(arr, 0, n);
    for (idx = 0; idx < n; idx++) {
    	cout << (idx == 0 ? "" : " ") << arr[idx];
    }
    delete [] arr;
	return 0;
}