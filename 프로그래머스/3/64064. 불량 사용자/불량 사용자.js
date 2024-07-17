function solution(userIds, bannedIds) {
    const bannedMappings = bannedIds.map(bannedId =>
        userIds.filter(userId => isValid(userId, bannedId))
    ); // 조건에 맞는 유저 아이디만 남기기

    const queue = [[]];// 일단 가능한 조합 다 모으기
    let index = 0;

    while (index < bannedIds.length) {
        const length = queue.length;
        for (let i = 0; i < length; i++) {
            const current = queue.shift(); // 앞에꺼 꺼내서

            for (const userId of bannedMappings[index]) {
                if (!current.includes(userId)) {
                    const newCombination = [...current, userId];
                    queue.push(newCombination); // 큐에 넣기
                }
            }
        }
        index++;
    }

    // Set으로 가능한 조합 필터링
    const uniqueCombinations = new Set(
        queue.map(combination => combination.sort().join(','))
    );

    return uniqueCombinations.size;
}

function isValid(userId, bannedId) {
    if (userId.length !== bannedId.length) return false; // 글자수 안 맞으면 패스
    for (let i = 0; i < userId.length; i++) {
        if (bannedId[i] !== '*' && userId[i] !== bannedId[i]) { // *표 와일드 카드
            return false;
        }
    }
    return true; // 모든 조건을 만족하면 true
}