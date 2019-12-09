//
// Copyright 2018 Vinícius Jorge Vendramini
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//

class UtilitiesTest(): XCTestCase() {
    override fun getClassName(): String {
        return "UtilitiesTest"
    }
    
	override fun runAllTests() {
		testExpandSwiftAbbreviation()
		testFileExtensions()
		testChangeExtension()
		super.runAllTests()
	}

	fun testExpandSwiftAbbreviation() {
		XCTAssertEqual(
			Utilities.expandSwiftAbbreviation("source_file"), "Source File")
		XCTAssertEqual(
			Utilities.expandSwiftAbbreviation("import_decl"), "Import Declaration")
		XCTAssertEqual(
			Utilities.expandSwiftAbbreviation("declref_expr"), "Declaration Reference Expression")
	}

	fun testFileExtensions() {
		XCTAssertEqual(FileExtension.SWIFT_AST_DUMP.rawValue, "swiftASTDump")
		XCTAssertEqual("fileName".withExtension(FileExtension.SWIFT_AST_DUMP), "fileName.swiftASTDump")
	}

	fun testChangeExtension() {
		XCTAssertEqual(
			Utilities.changeExtension("test.txt", FileExtension.SWIFT), 
			"test.swift")
		XCTAssertEqual(
			Utilities.changeExtension("/path/to/test.txt", FileExtension.SWIFT), 
			"/path/to/test.swift")
		XCTAssertEqual(
			Utilities.changeExtension("path/to/test.txt", FileExtension.SWIFT), 
			"path/to/test.swift")
		XCTAssertEqual(
			Utilities.changeExtension("/path/to/test", FileExtension.SWIFT),
			"/path/to/test.swift")
		XCTAssertEqual(
			Utilities.changeExtension("path/to/test", FileExtension.SWIFT),
			"path/to/test.swift")
	}
}
