function solution(word, pages) {
    const pageMap = new Map();
    const urlPattern = /<meta property="og:url" content="(.*?)"\/>/;
    const linkPattern = /<a href="(.*?)">/g;
    word = word.toLowerCase();

    pages.forEach((pageContent, index) => {
        const urlMatch = pageContent.match(urlPattern);
        if (urlMatch) {
            const url = urlMatch[1];
            const page = {
                url,
                baseScore: countWord(pageContent, word),
                linkCount: 0,
                linkScore: 0,
                matchingScore: 0,
                outLink: []
            };

            const linkMatches = [...pageContent.matchAll(linkPattern)];
            linkMatches.forEach(match => {
                page.outLink.push(match[1]);
            });
            page.linkCount = page.outLink.length;

            pageMap.set(url, page);
        }
    });

    pageMap.forEach((page) => {
        if (page.linkCount > 0) {
            const linkScore = page.baseScore / page.linkCount;
            page.outLink.forEach((outLink) => {
                if (pageMap.has(outLink)) {
                    pageMap.get(outLink).linkScore += linkScore;
                }
            });
        }
    });

    let maxMatchingScore = 0;
    let answer = 0;
    pages.forEach((pageContent, i) => {
        const urlMatch = pageContent.match(urlPattern);
        if (urlMatch) {
            const url = urlMatch[1];
            const page = pageMap.get(url);
            page.matchingScore = page.baseScore + page.linkScore;
            if (page.matchingScore > maxMatchingScore) {
                maxMatchingScore = page.matchingScore;
                answer = i;
            }
        }
    });

    return answer;
}

function countWord(html, word) {
    const bodyMatch = html.match(/<body>(.*?)<\/body>/s);
    if (!bodyMatch) return 0;

    const bodyContent = bodyMatch[1].toLowerCase();
    const words = bodyContent.split(/[^a-zA-Z]+/);
    return words.reduce((count, w) => count + (w === word ? 1 : 0), 0);
}