func GRYKotlinLiteral<T>(_ swiftExpression: T, _ kotlinExpression: String) -> T {
	return swiftExpression
}

let languageName = GRYKotlinLiteral("swift", "\"kotlin\"")
print("Hello from \(languageName)!")
