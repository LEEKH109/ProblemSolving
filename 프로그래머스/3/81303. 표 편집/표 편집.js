// 노드 링크드 리스트
// 2번 테케가 전부 삭제 문제라서 해당 부분 주의
class Node {
    constructor(index) {
        this.index = index;
        this.prev = null;
        this.next = null;
    }
}

function solution(n, k, cmd) {
    // 초기 노드 생성
    let start = new Node(0);
    let currentNode = start;
    // 링크드리스트 생성
    for (let i = 1; i < n; i++) {
        let newNode = new Node(i);
        currentNode.next = newNode;// 앞
        newNode.prev = currentNode;// 뒤로 값 넣어주고
        currentNode = newNode;// 다음 노드로 이동
    }
    // k 노드로 세팅
    let now = start;
    for (let i = 0; i < k; i++) {
        now = now.next;
    }
    const del = [];  // 삭제된 노드들을 저장할 스택
    // 명령어 스위치 케이스로 처리
    for (let i = 0; i < cmd.length; i++) {
        const [command, X] = cmd[i].split(" ");
        let move;
        switch (command) {
            case "U":
                move = parseInt(X, 10);// 숫자로 변환
                for (let j = 0; j < move; j++) now = now.prev;
                break;
            case "D":
                move = parseInt(X, 10);// 숫자로 변환
                for (let j = 0; j < move; j++) now = now.next;
                break;
            case "C":
                del.push(now);
                if (now.prev) now.prev.next = now.next;
                if (now.next) now.next.prev = now.prev;
                if (now === start) {
                    start = now.next; // 첫 번째 노드 삭제 시, 새로운 시작점 설정
                }
                now = now.next ? now.next : now.prev;
                break;
            case "Z":
                const recovered = del.pop();
                if (recovered.prev) recovered.prev.next = recovered;
                if (recovered.next) recovered.next.prev = recovered;
                if (recovered.prev === null) {
                    start = recovered; // 복구된 노드가 새로운 시작점이 될 수 있음
                }
                break;
        }
    }

    // 결과 문자열 생성
    const answer = Array(n).fill("X");
    currentNode = start;
    while (currentNode) {
        answer[currentNode.index] = 'O';
        currentNode = currentNode.next;
    }

    return answer.join('');
}